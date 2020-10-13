#Creating the Blocks
// Java implementation for creating 
// a block in a Blockchain 

import java.util.Date; 

public class Block { 

	// Every block contains 
	// a hash, previous hash and 
	// data of the transaction made 
	public String hash; 
	public String previousHash; 
	private String data; 
	private long timeStamp; 

	// Constructor for the block 
	public Block(String data, 
				String previousHash) 
	{ 
		this.data = data; 
		this.previousHash 
			= previousHash; 
		this.timeStamp 
			= new Date().getTime(); 
		this.hash 
			= calculateHash(); 
	} 

	// Function to calculate the hash 
	public String calculateHash() 
	{ 
		// Calling the "crypt" class 
		// to calculate the hash 
		// by using the previous hash, 
		// timestamp and the data 
		String calculatedhash 
			= crypt.sha256( 
				previousHash 
				+ Long.toString(timeStamp) 
				+ data); 

		return calculatedhash; 
	} 
} 

#Generating Hashes
// Java program for Generating Hashes 

import java.security.MessageDigest; 

public class crypt { 

	// Function that takes the string input 
	// and returns the hashed string. 
	public static String sha256(String input) 
	{ 
		try { 
			MessageDigest sha 
				= MessageDigest 
					.getInstance( 
						"SHA-256"); 
			int i = 0; 

			byte[] hash 
				= sha.digest( 
					input.getBytes("UTF-8")); 

			// hexHash will contain 
			// the Hexadecimal hash 
			StringBuffer hexHash 
				= new StringBuffer(); 

			while (i < hash.length) { 
				String hex 
					= Integer.toHexString( 
						0xff & hash[i]); 
				if (hex.length() == 1) 
					hexHash.append('0'); 
				hexHash.append(hex); 
				i++; 
			} 

			return hexHash.toString(); 
		} 
		catch (Exception e) { 
			throw new RuntimeException(e); 
		} 
	} 
} 

#Storing the blocks
// Java implementation to store 
// blocks in an ArrayList 

import java.util.ArrayList; 

public class GFG { 

	// ArrayList to store the blocks 
	public static ArrayList<Block> blockchain 
		= new ArrayList<Block>(); 

	// Driver code 
	public static void main(String[] args) 
	{ 
		// Adding the data to the ArrayList 
		blockchain.add(new Block( 
			"First block", "0")); 
		blockchain.add(new Block( 
			"Second block", 
			blockchain 
				.get(blockchain.size() - 1) 
				.hash)); 

		blockchain.add(new Block( 
			"Third block", 
			blockchain 
				.get(blockchain.size() - 1) 
				.hash)); 

		blockchain.add(new Block( 
			"Fourth block", 
			blockchain 
				.get(blockchain.size() - 1) 
				.hash)); 

		blockchain.add(new Block( 
			"Fifth block", 
			blockchain 
				.get(blockchain.size() - 1) 
				.hash)); 
	} 
} 

#Blockchain Validity
// Java implementation to check 
// validity of the blockchain 

// Function to check 
// validity of the blockchain 
public static Boolean isChainValid() 
{ 
	Block currentBlock; 
	Block previousBlock; 

	// Iterating through 
	// all the blocks 
	for (int i = 1; 
		i < blockchain.size(); 
		i++) { 

		// Storing the current block 
		// and the previous block 
		currentBlock = blockchain.get(i); 
		previousBlock = blockchain.get(i - 1); 

		// Checking if the current hash 
		// is equal to the 
		// calculated hash or not 
		if (!currentBlock.hash 
				.equals( 
					currentBlock 
						.calculateHash())) { 
			System.out.println( 
				"Hashes are not equal"); 
			return false; 
		} 

		// Checking of the previous hash 
		// is equal to the calculated 
		// previous hash or not 
		if (!previousBlock 
				.hash 
				.equals( 
					currentBlock 
						.previousHash)) { 
			System.out.println( 
				"Previous Hashes are not equal"); 
			return false; 
		} 
	} 

	// If all the hashes are equal 
	// to the calculated hashes, 
	// then the blockchain is valid 
	return true; 
} 

