package com.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY) //il va g�n�rer des codes automatiquement
	private Integer codigo;
	
	@Column(name="descricao", length=50, nullable=false)
	private String descricao;
	
	@Column(name="diashorarios", length=50, nullable=false)
	private String diashorarios;
	
	
	@ManyToOne //ici, nous avons plusieurs cursos qui peut-�tre li� � un professeur
	@JoinColumn(name="curs_prof_codigo", referencedColumnName="codigo")
	private Professor professor;

	public Curso() {

	}

	public Curso(Integer codigo, String descricao, String diashorarios, Professor professor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.diashorarios = diashorarios;
		this.professor = professor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDiashorarios() {
		return diashorarios;
	}

	public void setDiashorarios(String diashorarios) {
		this.diashorarios = diashorarios;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
