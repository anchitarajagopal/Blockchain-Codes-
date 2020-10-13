Blockchain Codes 

1. Minimal Blockchain using Python

Developed in the following stages:
Hashing: 
Hashing is a function H(x) that satisfies the following properties:
The same input x always produce the same output H(x).
Different (or even similar) inputs x should produce entirely different outputs H(x).
Computationally easy to get H(x)from input x, but intractable to reverse the process, i.e. getting the input x from a known hash H
Minimal Block:
It is an object class, initialized by index, a timestamp, data to be stored and a previous_hash. Previous_hash works as a pointer to the previous block, and is the    hash(key function of the block. 
Block[x] contains index x, a timestamp, some data, and the hash of the previous block x-1 H(Block[x-1]). Now that this block is complete, it can be hashed to generate H(Block[x]) as a pointer in the next block.
Minimal Chain:
A chain can be implemented using a Python list, and blocks[i] representing the {i}th block. When we initialize a chain, we automatically assign a 0th block, known as Genesis block, to the chain with function get_genesis_block(). This block marks the start of your chain
Data Verification:
We use function verify(), to check the following:
  Index in blocks[i] is i, and hence no missing or extra blocks.
  Compute block hash H(blocks[i]) and cross-check with the recorded hash. Even if a single bit in a block is altered, the computed block hash would be entirely different.
  Verify if H(blocks[i]) is correctly stored in next block’s previous_hash.
  Check if there is any backdating by looking into the timestamps.
Forking
Using the fork() function, you may branch out of a chain. 

2. Implementing blockchain in Java 
A) Creating a block
A block class is created. It contains:
. hash will contain the hash of the block and
. previousHash will contain the hash of the previous block.
. String data is used to store the data of the block and
. “long timeStamp” is used to store the timestamp of the block. Here long data type is used to store the number of milliseconds.
. calculateHash() to generate the hash
B) Generating Hashes
This is done using the SHA256 algorithm. SHA is cryptographic hash function which takes input as 20 Bytes and rendered the hash value in hexadecimal number, 40 digits long approx
C) Storing the blocks
Now we Now store the blocks in the ArrayList of Block type, along with their hash values by calling the constructor of the Block Class.
D) Blockchain validity
We check the validity of the BlockChain by creating a boolean method to check the validity. This method will be implemented in the “Main” class and checks whether the hash is equal to the calculated hash or not. If all the hashes are equal to the calculated hashes, then the block is valid.
