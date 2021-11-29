package src.Donnees;

class Client extends ObjetModifiable {
    private final int id;

    Client(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    @Override
    void initialiser() {
        objetLu.creationObjetModifiable();
    }
}
