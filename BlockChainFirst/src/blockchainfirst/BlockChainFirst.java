/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainfirst;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sohesh
 */
class Block {

    /**
     * @param args the command line arguments
     */
    public String hash; //hold digital signuture
    public String previousHash; //previous hash
    private String data; //our data will be a simple message.
    private long timeStamp;

    //Block Constructor.
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash
                + Long.toString(timeStamp)
                + data
        );
        return calculatedhash;
    }
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 

    public static void main(String[] args) {

        Block genesisBlock = new Block("Hi im the first block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.hash);

        Block secondBlock = new Block("Yo im the second block", genesisBlock.hash);
        System.out.println("Hash for block 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("Hey im the third block", secondBlock.hash);
        System.out.println("Hash for block 3 : " + thirdBlock.hash);
       

    }

}
