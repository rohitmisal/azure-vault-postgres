package org.acme.azure.main;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretBundle;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusMainStart {

	public static void main(String[] args) {
		System.out.println("hello");
		
	
/*		 String clientId = "dd9c0de0-7dc4-4806-b836-73412b76f970";
			String clientKey = "ft_8Q~MQzofrDcnuyBR.c3Li1P~oxPUQ06.tHcWj";
			String tenantId = "ccdded2b-ca2a-477a-b6ae-e508aa356b55";*/
			
			 String clientId = "9c6e3f14-xx-4xxx-acx5-XXXXXXX";
				String clientKey = "MAF8Q~XXXXXX~XXXXXX";
				String tenantId = "3539451e-Xxxx-4a26-a242-XXXX";

			ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder().clientId(clientId)
					.clientSecret(clientKey).tenantId(tenantId).build();

			System.out.println("ClientSecretCredential build done:");

			// Azure SDK client builders accept the credential as a parameter
			SecretClient secretClient = new SecretClientBuilder().vaultUrl("https://optvult.vault.azure.net/")
					.credential(clientSecretCredential).buildClient();

		
			  System.out.println("SecretClient build done:"); secretClient.setSecret(new
			  KeyVaultSecret("db-user", "kpit"));
			  
			  System.out.println("done.");
			 
			 
			KeyVaultSecret secret1 = secretClient.getSecret("db-user");
			System.out.println("secret :" + secret1.getValue());

		
		Quarkus.run(args);
	}
	
}
