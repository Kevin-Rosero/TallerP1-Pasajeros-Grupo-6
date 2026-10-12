import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola {
    private final Queue<Pasajero> coleccion;

    public Cola() {
        coleccion = new LinkedList<>();
    }

    public void agregar(Pasajero p) {

    }
    //R2 Parte 2
    public int posicionPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException(
                    "El asiento debe estar entre 1 y 30");
        }

        int posicion = 1;
        for (Pasajero pasajero : coleccion) {
            if (pasajero.getNumeroAsiento() == asiento) {
                return posicion;
            }
            posicion++;
        }

        return -1;
    }
    //R3
    public Pasajero cancelarPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30");
        }

        Iterator<Pasajero> it = coleccion.iterator();
        while (it.hasNext()) {
            Pasajero pasajero = it.next();
            if (pasajero.getNumeroAsiento() == asiento) {
                it.remove();
                return pasajero;
            }
        }

        throw new NoSuchElementException("No hay un pasajero pendiente en el asiento " + asiento);
    }

    @Override
    public String toString() {
        if (coleccion.isEmpty()) {
            return "Cola sin elementos";
        }
        StringBuilder sb = new StringBuilder();
        int posicion = 1;
        for (Pasajero p : coleccion) {
            sb.append(posicion++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }
}
