package com.example.firmas;

public class Transacciones {

    public static final String Tabla = "TblFirmas";

    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String firma = "firma";

    public static final String CREATETABLE = "CREATE TABLE TblFirmas(id INTEGER PRIMARY KEY AUTOINCREMENT, firma BLOB,descripcion TEXT)";

    public static final String DROPTABLE = "DROP TABLE IF EXISTS TblFirmas";

    public static final String NameDataBase = "Firmas";
    public static final String test1 = "select * from TblFirmas";
}
