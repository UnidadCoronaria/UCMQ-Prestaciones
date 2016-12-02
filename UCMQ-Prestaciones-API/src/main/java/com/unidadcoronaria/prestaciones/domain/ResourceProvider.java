package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_RECURSOPRESTADOR", sequenceName = "IDRECURSOPRESTADOR")
@Table(name="RECURSOSPRESTADORES")
public class ResourceProvider {
	
	@Id
	@Column(name = "IDRECURSOPRESTADOR")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_RECURSOPRESTADOR")
	private Integer resourceProviderId;
	
	@ManyToOne
	@JoinColumn(name = "IDRECURSO")
	private Resource resource;
	
	@Column(name = "IDPRESTADOR")
	private Integer providerId;
	
	@ManyToOne
	@JoinColumn(name = "IDGUARDIA")
	private Guard guard;

	public Integer getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(Integer resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}
	
	

}
