package com.stage.project.data;

import java.io.File;
import java.sql.Date;
import java.io.InputStream;

public class FascicoloInfo {
 

 protected int id;
 protected String nomina;
 protected String procura;
 protected String pm;
 protected String pg;
 protected String indagato;
 protected String reato;
 protected String consulente;
 protected String ausiliario;
 protected String d_incarico;
 protected String d_inizio;
 protected int giorni;
 protected String scadenza;
 protected int proroga;
 protected String richiesta;
 //protected String relazione;
 InputStream relazione;
 protected String costo;
 protected String pagamento;
 
 public FascicoloInfo() {
 }
 
 public FascicoloInfo(String nomina, String procura, String pm, String pg, String indagato, String reato,
		 		String consulente, String ausiliario, String d_incarico, String d_inizio, int giorni, String scadenza,
		 		int proroga, String richiesta,InputStream relazione, String costo, String pagamento) {
  super();
  this.nomina = nomina;
  this.procura = procura;
  this.pm = pm;
  this.pg = pg;
  this.indagato = indagato;
  this.reato = reato;
  this.consulente = consulente;
  this.ausiliario = ausiliario;
  this.d_incarico = d_incarico;
  this.d_inizio = d_inizio;
  this.giorni = giorni;
  this.scadenza = scadenza;
  this.proroga = proroga;
  this.richiesta = richiesta;
  this.relazione = relazione;
  this.costo = costo;
  this.pagamento = pagamento;
 }

 public FascicoloInfo(int id, String nomina, String procura, String pm, String pg, String indagato, String reato,
	 		String consulente, String ausiliario, String d_incarico, String d_inizio, int giorni, String scadenza,
	 		int proroga, String richiesta, String costo, String pagamento) {
  super();
  this.id = id;
  this.nomina = nomina;
  this.procura = procura;
  this.pm = pm;
  this.pg = pg;
  this.indagato = indagato;
  this.reato = reato;
  this.consulente = consulente;
  this.ausiliario = ausiliario;
  this.d_incarico = d_incarico;
  this.d_inizio = d_inizio;
  this.giorni = giorni;
  this.scadenza = scadenza;
  this.proroga = proroga;
  this.richiesta = richiesta;
  //this.relazione = relazione;
  this.costo = costo;
  this.pagamento = pagamento;
 }
 
 public FascicoloInfo(String procura, String pm, String pg, String indagato, String reato,
	 		String consulente, String ausiliario, String d_incarico, String d_inizio, int giorni, String scadenza,
	 		int proroga, String richiesta, String costo, String pagamento) {
super();
this.procura = procura;
this.pm = pm;
this.pg = pg;
this.indagato = indagato;
this.reato = reato;
this.consulente = consulente;
this.ausiliario = ausiliario;
this.d_incarico = d_incarico;
this.d_inizio = d_inizio;
this.giorni = giorni;
this.scadenza = scadenza;
this.proroga = proroga;
this.richiesta = richiesta;
//this.relazione = relazione;
this.costo = costo;
this.pagamento = pagamento;
}
 
 public FascicoloInfo(String nomina) {
	 this.nomina = nomina;
 }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 
 public String getNomina() {
	  return nomina;
	 }
 public void setNomina(String nomina) {
	  this.nomina = nomina;
	 }
 public String getProcura() {
	  return procura;
	 }
 public void setProcura(String procura) {
	  this.procura = procura;
	 }

public String getPm() {
	return pm;
}

public void setPm(String pm) {
	this.pm = pm;
}

public String getPg() {
	return pg;
}

public void setPg(String pg) {
	this.pg = pg;
}

public String getIndagato() {
	return indagato;
}

public void setIndagato(String indagato) {
	this.indagato = indagato;
}

public String getReato() {
	return reato;
}

public void setReato(String reato) {
	this.reato = reato;
}

public String getConsulente() {
	return consulente;
}

public void setConsulente(String consulente) {
	this.consulente = consulente;
}

public String getAusiliario() {
	return ausiliario;
}

public void setAusiliario(String ausiliario) {
	this.ausiliario = ausiliario;
}

public String getD_incarico() {
	return d_incarico;
}

public void setD_incarico(String d_incarico) {
	this.d_incarico = d_incarico;
}

public String getD_inizio() {
	return d_inizio;
}

public void setD_inizio(String d_inizio) {
	this.d_inizio = d_inizio;
}

public int getGiorni() {
	return giorni;
}

public void setGiorni(int giorni) {
	this.giorni = giorni;
}

public String getScadenza() {
	return scadenza;
}

public void setScadenza(String scadenza) {
	this.scadenza = scadenza;
}

public int getProroga() {
	return proroga;
}

public void setProroga(int proroga) {
	this.proroga = proroga;
}

public String getRichiesta() {
	return richiesta;
}

public void setRichiesta(String richiesta) {
	this.richiesta = richiesta;
}

public InputStream getRelazione() {
	return relazione;
}

public void setRelazione(InputStream relazione) {
	this.relazione = relazione;
}

public String getCosto() {
	return costo;
}

public void setCosto(String costo) {
	this.costo = costo;
}

public String getPagamento() {
	return pagamento;
}

public void setPagamento(String pagamento) {
	this.pagamento = pagamento;
}
 
}