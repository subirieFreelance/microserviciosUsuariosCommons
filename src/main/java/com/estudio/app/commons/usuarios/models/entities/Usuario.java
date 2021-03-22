package com.estudio.app.commons.usuarios.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true, length=20)
	private String username;
	@Column(length=60)
	private String password;
	private String activo;
	@JoinTable(name="usuariorol", joinColumns= @JoinColumn(name="idusuario"), 
			   inverseJoinColumns = @JoinColumn(name="idrol"),
			   uniqueConstraints = {@UniqueConstraint(columnNames = {"idusuario","idrol"})})
	@ManyToMany(fetch = FetchType.LAZY)
	List<Rol> roles;
}