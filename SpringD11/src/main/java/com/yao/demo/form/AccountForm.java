package com.yao.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.yao.demo.domain.Account;

public class AccountForm {
	
	public AccountForm() {
		
	}
	
	@NotBlank
    private String accountName;
    
	@NotBlank
    private String firstName;

	@NotBlank
    private String lastName;

    @NotBlank
    @Length(min = 8)
    @Pattern(regexp="")
    private String password;

    private String confirmPassword;

    private String photoPath;

    private String authGroup;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}
	
	public Account ConvertToAccount() {
		Account account = new AccountFormConvert().convert(this);
		return account;
	}
	
	@Override
	public String toString() {
		return "AccountForm [accountName=" + accountName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", photoPath=" + photoPath
				+ ", authGroup=" + authGroup + "]";
	}
	
	private class AccountFormConvert implements FormConvert<AccountForm, Account>{

		@Override
		public Account convert(AccountForm accountForm) {
			Account account = new Account();
			BeanUtils.copyProperties(accountForm, account);
			return account;
		}
	}
	
};