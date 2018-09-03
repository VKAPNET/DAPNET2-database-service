package de.hampager.dapnet.service.database.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDetailObject implements Serializable {

	private static final long serialVersionUID = 1L;
	@Pattern(regexp = "[A-Za-z0-9]")
	@JsonProperty(value = "_id", required = true)
	private String id;
	@NotEmpty(groups = CreateObjectChecks.class)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Email(groups = CreateObjectChecks.class)
	private String email;
	@NotNull(groups = CreateObjectChecks.class)
	@JsonProperty(required = true)
	private boolean enabled;
	@JsonProperty(value = "email_valid")
	private boolean emailValid;
	@NotEmpty(groups = CreateObjectChecks.class)
	@JsonProperty(required = true)
	private Set<String> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEmailValid() {
		return emailValid;
	}

	public void setEmailValid(boolean emailValid) {
		this.emailValid = emailValid;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
