public class Pokemon {
    private Integer numero;
    private String nome;
    private String tipo1;
    private String tipo2;
    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spatk;
    private Integer spdef;
    private Integer spd;
    private Boolean mega;
    private Boolean lendario;
    private String regiao;

    // Constructors
    public Pokemon(Integer numero, String nome, String tipo1, String tipo2, Integer hp, Integer atk, Integer def,
            Integer spatk, Integer spdef, Integer spd, Boolean mega, Boolean lendario, String regiao) {
        this.numero = numero;
        this.nome = nome;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.spd = spd;
        this.mega = mega;
        this.lendario = lendario;
        this.regiao = regiao;
    }

    public Pokemon(Integer numero, String nome, String tipo1, Integer hp, Integer atk, Integer def, Integer spatk,
            Integer spdef, Integer spd, Boolean mega, Boolean lendario, String regiao) {
        this.numero = numero;
        this.nome = nome;
        this.tipo1 = tipo1;
        this.tipo2 = null;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.spd = spd;
        this.mega = mega;
        this.lendario = lendario;
        this.regiao = regiao;
    }

    public Pokemon(Integer numero, String nome, String tipo1, Integer hp, Integer atk, Integer def, Integer spatk,
            Integer spdef, Integer spd) {
        this.numero = numero;
        this.nome = nome;
        this.tipo1 = tipo1;
        this.tipo2 = null;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.spd = spd;
        this.mega = null;
        this.lendario = null;
        this.regiao = null;
    }

    // Getters and Setter
    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo1() {
        return this.tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return this.tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public Integer getHp() {
        return this.hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtk() {
        return this.atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return this.def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getSpatk() {
        return this.spatk;
    }

    public void setSpatk(Integer spatk) {
        this.spatk = spatk;
    }

    public Integer getSpdef() {
        return this.spdef;
    }

    public void setSpdef(Integer spdef) {
        this.spdef = spdef;
    }

    public Integer getSpd() {
        return this.spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }

    public Boolean getMega() {
        return this.mega;
    }

    public void setMega(Boolean mega) {
        this.mega = mega;
    }

    public Boolean getLendario() {
        return this.lendario;
    }

    public void setLendario(Boolean lendario) {
        this.lendario = lendario;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
