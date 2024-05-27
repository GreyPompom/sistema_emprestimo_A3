
package model.Enumo;
public enum StatusEmprestimo {
    ABERTO(1),
    FECHADO(2),
    EM_ATRASO(3);

    private final int codigo;

    StatusEmprestimo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusEmprestimo fromCodigo(int codigo) {
        for (StatusEmprestimo status : StatusEmprestimo.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}