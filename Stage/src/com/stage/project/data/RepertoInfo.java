package com.stage.project.data;

//import java.io.File;
//import java.sql.Date;

public class RepertoInfo {


protected int id;
protected String nominarep;
protected String nreperto;
protected String sequestrato;
protected String supporto;
protected String seriale;
protected String note;
protected String operazioni;

public RepertoInfo() {
}

public RepertoInfo(String nominarep, String nreperto, String sequestrato, String supporto, String seriale, String note,
		 		String operazioni) {
super();
this.nominarep = nominarep;
this.nreperto = nreperto;
this.sequestrato = sequestrato;
this.supporto = supporto;
this.seriale = seriale;
this.note = note;
this.operazioni = operazioni;
}

public RepertoInfo(String nreperto, String sequestrato, String supporto, String seriale, String note,
	 		String operazioni) {
super();
this.nreperto = nreperto;
this.sequestrato = sequestrato;
this.supporto = supporto;
this.seriale = seriale;
this.note = note;
this.operazioni = operazioni;
}

public RepertoInfo(String nominarep) {
	 this.nominarep = nominarep;
}

public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}

public String getNomina() {
	  return nominarep;
	 }
public void setNomina(String nomina) {
	  this.nominarep = nomina;
	 }

public String getNreperto() {
	return nreperto;
}

public void setNreperto(String nreperto) {
	this.nreperto = nreperto;
}

public String getSequestrato() {
	return sequestrato;
}

public void setSequestrato(String sequestrato) {
	this.sequestrato = sequestrato;
}

public String getSupporto() {
	return supporto;
}

public void setSupporto(String supporto) {
	this.supporto = supporto;
}

public String getSeriale() {
	return seriale;
}

public void setSeriale(String seriale) {
	this.seriale = seriale;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getOperazioni() {
	return operazioni;
}

public void setOperazioni(String operazioni) {
	this.operazioni = operazioni;
}

}