package co.edu.poli.ejemplo.modelo;

public class Proveedor {

    // Propiedades del proveedor
    private String nombre;
    private Certificacion certificacion;
    private Evaluacion evaluacion;
    private PoliticaEntrega politicaEntrega;

    // Constructor privado, se utiliza a través del Builder
    private Proveedor(Builder builder) {
        this.nombre = builder.nombre;
        this.certificacion = builder.certificacion;
        this.evaluacion = builder.evaluacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    // Métodos de acceso (Getters)
    public String getNombre() {
        return nombre;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public PoliticaEntrega getPoliticaEntrega() {
        return politicaEntrega;
    }

    // Inner Class Builder
    public static class Builder {

        private String nombre;
        private Certificacion certificacion;
        private Evaluacion evaluacion;
        private PoliticaEntrega politicaEntrega;

        // Método para establecer el nombre
        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        // Métodos para establecer las clases accesorias
        public Builder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }

        public Builder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }

        // Método para construir el objeto Proveedor
        public Proveedor build() {
            return new Proveedor(this);
        }
    }

    // Inner Class Certificacion (con un solo atributo)
    public static class Certificacion {

        private String nombreCertificacion;

        public Certificacion(String nombreCertificacion) {
            this.nombreCertificacion = nombreCertificacion;
        }

        public String getNombreCertificacion() {
            return nombreCertificacion;
        }
    }

    // Inner Class Evaluacion (con un solo atributo)
    public static class Evaluacion {

        private String tipo;

        public Evaluacion(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    }

    // Inner Class PoliticaEntrega (con un solo atributo)
    public static class PoliticaEntrega {

        private String condiciones;

        public PoliticaEntrega(String condiciones) {
            this.condiciones = condiciones;
        }

        public String getCondiciones() {
            return condiciones;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor: ").append(nombre).append("\n");
        if (certificacion != null) {
            sb.append("Certificación: ").append(certificacion.getNombreCertificacion()).append("\n");
        }
        if (evaluacion != null) {
            sb.append("Evaluación: ").append(evaluacion.getTipo()).append("\n");
        }
        if (politicaEntrega != null) {
            sb.append("Política de Entrega: ").append(politicaEntrega.getCondiciones()).append("\n");
        }
        return sb.toString();
    }
}
