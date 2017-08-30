package sampleapplication

class User {

    String firstName
    String lastName

    static constraints = {
    }

    @Override
    String toString() {
        "${firstName} ${lastName}"
    }
}
