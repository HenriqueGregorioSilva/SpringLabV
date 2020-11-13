package dream.team.cetriolo.sprintbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonView;

import dream.team.cetriolo.sprintbootapp.controller.View;

public class Usuario {

    @JsonView(View.UsuarioCompleta.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long id;
	
	@JsonView({View.UsuarioResumo.class, View.AutorizacaoResumo.class})
	@Column(name = "usr_nome")
	private String nome;
	
	@JsonView(View.UsuarioCompleta.class)
	@Column(name = "usr_senha")
	private String senha;
	

	@JsonView({View.UsuarioResumo.class})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "uau_usuario_autorizacao", 
		joinColumns = { @JoinColumn(name = "usr_id") },
		inverseJoinColumns = {@JoinColumn(name = "aut_id")})
	private Set<Autorizacao>autorizacoes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

    public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
    
}