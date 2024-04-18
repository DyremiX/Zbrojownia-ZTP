from flask import Flask, jsonify, make_response, request

app = Flask(__name__)

class Pracownik:
    def __init__(self, id, imie, nazwisko, stanowisko):
        self.id = id
        self.imie = imie
        self.nazwisko = nazwisko
        self.stanowisko = stanowisko
    
    def json(self):
        return jsonify({'id': self.id, 'imie': self.imie, 'nazwisko': self.nazwisko, 'stanowisko': self.stanowisko})

tablica_pracownikow = [
    Pracownik(1, "Jan", "Kowalski", "Inżynier"),
    Pracownik(2, "Anna", "Nowak", "Księgowa"),
    Pracownik(3, "Marek", "Nowicki", "Programista")
]

def znajdz_pracownika_po_id(id_szukanego):
    for pracownik in tablica_pracownikow:
        if pracownik.id == int(id_szukanego):
            return pracownik
    return 0

@app.route("/worker/<int:id>", methods=["GET"])
def get_pracownik(id):
    pracownik = znajdz_pracownika_po_id(id)
    if pracownik == 0:
        return make_response(jsonify({'message': 'Pracownik o podanym ID nie istnieje'}), 404)
    else:
        return znajdz_pracownika_po_id(int(id)).json()
    
@app.route("/workers", methods=["GET"])
def get_pracownicy():
    return jsonify([{'id': pracownik.id, 'imie': pracownik.imie, 'nazwisko': pracownik.nazwisko, 'stanowisko': pracownik.stanowisko} for pracownik in tablica_pracownikow])


@app.route("/worker", methods=["POST"])
def dodaj_pracownika():
    nowy_pracownik_id = int(request.json['id'])
    
    for pracownik in tablica_pracownikow:
        if pracownik.id == nowy_pracownik_id:
            return make_response(jsonify({'message': 'Pracownik o podanym ID już istnieje'}), 409)
    
    nowy_pracownik = Pracownik(id=nowy_pracownik_id, imie=request.json['imie'], nazwisko=request.json['nazwisko'], stanowisko=request.json['stanowisko'])
    tablica_pracownikow.append(nowy_pracownik)
    
    return make_response(jsonify({'message': 'Pracownik został dodany'}), 202)


@app.route("/worker", methods=["PUT"])
def zmien_pracownika():
    pracownik_id = int(request.json['id'])
    for pracownik in tablica_pracownikow:
        if pracownik.id == pracownik_id:
            pracownik.imie = request.json['imie']
            pracownik.nazwisko = request.json['nazwisko']
            pracownik.stanowisko = request.json['stanowisko']
            return make_response(jsonify({'message': 'Pracownik o podanym ID został zaaktualizowany'}), 202)
    
    return make_response(jsonify({'message': 'Pracownik o podanym ID nie istnieje'}), 404)