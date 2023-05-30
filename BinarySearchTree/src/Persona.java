import java.util.Objects;

public class Persona implements Comparable<Persona>{

    private String nom;
    private String dni;

    public Persona (String n, String id)
    {
        nom = n;
        dni = id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getDNI()
    {
        return dni;
    }

    public void setNom(String n)
    {
        nom = n;
    }

    public void setDni (String id)
    {
        dni = id;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj instanceof Persona)
        {
            Persona aux = (Persona)obj;
            return (aux.getDNI().equals(this.getDNI())
                    && (aux.getNom().equals(this.getNom())));
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public int compareTo (Persona esa)
    {
        return (this.getDNI().compareTo(esa.getDNI()));
    }

    @Override
    public String toString()
    {
        return "Nom: " + this.nom + " DNI: " + this.dni;
    }
}

