package Donnees;

class Client implements ObjetModifiable {
    private final int id;

    Client(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }
}
