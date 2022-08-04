package com.foodmunch.Controller;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.Constants;
import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Exceptions.CustomException;
import com.foodmunch.Services.CustomerAddressService;
import com.foodmunch.Services.CustomerService;
import com.foodmunch.Services.FoodMenuService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerAddressService addressService;

	@Autowired
	CustomerAddressService customerAddressService;


	/*
	 * *************************************************************************
	 *  create operations
	 * ***********************************************************************
	 */
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<Customer> createUser(@Valid @RequestBody Customer user) {

		return new ResponseEntity<Customer>(customerService.userSignUp(user), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getUserById/{userId}")
	public ResponseEntity<Customer> getUserById(@Valid @PathVariable("userId") long userId) {
		return new ResponseEntity<Customer>(customerService.readUserById(userId), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getUser/{userId}/{userPassword}")
	public ResponseEntity<Customer> readUser(@Valid @PathVariable("userId") long userId,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<Customer>(customerService.readUser(userId, userPassword), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<Customer>> readUser() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/readUserByUserNameAndPassword/{userName}/{userPassword}")
	public ResponseEntity<Customer> readUserByUserNameAndPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) throws InvalidKeyException, CustomException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println(userName);
		System.out.println(userPassword);
		return new ResponseEntity<Customer>(customerService.readUserByUserNameAndPassword(Decrypt(userName), Decrypt(userPassword)), HttpStatus.OK);

	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	

	@DeleteMapping(value = "/deleteUser/{userId}/{userPassword}")
	public ResponseEntity<String> deleteByUserIdAndUserPassword(@Valid @PathVariable("userId") long userId,@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String>(customerService.deleteByUserIdAndUserPassword(userId, userPassword), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByUserNameAndUserPassword/{userName}/{userPassword}")
	public ResponseEntity<String> deleteByUserName(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword) throws CustomException{
		return new ResponseEntity<String> ( customerService.deleteByUserNameAndUserPassword(userName, userPassword), HttpStatus.OK);
	}



	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */


	@PutMapping(value = "/updateUser/{user}")
	public  ResponseEntity<Customer> updateUser(@Valid @RequestBody Customer user) {
		return new ResponseEntity<Customer>(customerService.updateUser(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updateUserPassword/{userName}/{userPassword}/{newUserPassword}")
	public ResponseEntity<Customer> updateUserPassword(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserPassword")String newUserPassword) {
		return new ResponseEntity<Customer>(customerService.updateUserPassword(userName, userPassword, newUserPassword), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUsermobile/{userName}/{userPassword}/{newUsermobile}")
	public ResponseEntity<Customer> updateUsermobile(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUsermobile") String newUsermobile) {
		return new ResponseEntity<Customer>(customerService.updateUsermobile(userName, userPassword, newUsermobile), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUserEmail/{userName}/{userPassword}/{newUserEmail}")
	public ResponseEntity<Customer> updateUserEmail(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("userPassword") String userPassword,
			@Valid @PathVariable("newUserEmail") String newUserEmail) {
		return new ResponseEntity<Customer>(customerService.updateUserEmail(userName, userPassword, newUserEmail), HttpStatus.ACCEPTED);
	}
	



	/*
	 * *************************************************************************
	 * authenticate operations
	 * ***********************************************************************
	 */
	@PostMapping(value = "/authenticate")
	public Map<String, String> generateToken(@RequestBody Customer customer){
		long timestamp=System.currentTimeMillis();
		String token=Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY)
			.setIssuedAt(new Date(timestamp))
			.setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
			.claim("customerId", customer.getCustomerId())
			.claim("customerName", customer.getCustomerName())
			.claim("customerEmail", customer.getCustomerEmail())
			.compact();
		Map<String, String> map= new HashMap<>();
		
		map.put("JWT", token);
		return map;
		
	}
	

	/*
	 * *************************************************************************
	 * Decryption operations
	 * ***********************************************************************
	 */
	
	public static String Decrypt(String cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String secret =  "René Über";
		//String cipherText = "U2FsdGVkX1+tsmZvCEFa/iGeSA0K7gvgs9KXeZKwbCDNCs2zPo+BXjvKYLrJutMK+hxTwl/hyaQLOaD7LLIRo2I5fyeRMPnroo6k8N9uwKk=";

		byte[] cipherData = Base64.getDecoder().decode(cipherText);
		byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
		SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
		IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

		byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
		Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
		aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] decryptedData = aesCBC.doFinal(encrypted);
		String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

		System.out.println(decryptedText);
		return decryptedText;
		
	}
	
	/**
	/**
 * Generates a key and an initialization vector (IV) with the given salt and password.
 * <p>
 * This method is equivalent to OpenSSL's EVP_BytesToKey function
 * (see https://github.com/openssl/openssl/blob/master/crypto/evp/evp_key.c).
 * By default, OpenSSL uses a single iteration, MD5 as the algorithm and UTF-8 encoded password data.
 * </p>
 * @param keyLength the length of the generated key (in bytes)
 * @param ivLength the length of the generated IV (in bytes)
 * @param iterations the number of digestion rounds 
 * @param salt the salt data (8 bytes of data or <code>null</code>)
 * @param password the password data (optional)
 * @param md the message digest algorithm to use
 * @return an two-element array with the generated key and IV
 */
public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

    int digestLength = md.getDigestLength();
    int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
    byte[] generatedData = new byte[requiredLength];
    int generatedLength = 0;

    try {
        md.reset();

        // Repeat process until sufficient data has been generated
        while (generatedLength < keyLength + ivLength) {

            // Digest data (last digest if available, password data, salt if available)
            if (generatedLength > 0)
                md.update(generatedData, generatedLength - digestLength, digestLength);
            md.update(password);
            if (salt != null)
                md.update(salt, 0, 8);
            md.digest(generatedData, generatedLength, digestLength);

            // additional rounds
            for (int i = 1; i < iterations; i++) {
                md.update(generatedData, generatedLength, digestLength);
                md.digest(generatedData, generatedLength, digestLength);
            }

            generatedLength += digestLength;
        }

        // Copy key and IV into separate byte arrays
        byte[][] result = new byte[2][];
        result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
        if (ivLength > 0)
            result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

        return result;

    } catch (DigestException e) {
        throw new RuntimeException(e);

    } finally {
        // Clean out temporary data
        Arrays.fill(generatedData, (byte)0);
    }
}

}