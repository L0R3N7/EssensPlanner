package me.workloads.person;

//import me.workloads.gerichte.Zutatenliste;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;

@Entity
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String email;
   private byte[] password;
   private byte[] uniqueSessionCode;
   private byte[] salt;

   @OneToMany(
           mappedBy = "id.person",
           cascade = CascadeType.ALL
   )
   @OnDelete(action = OnDeleteAction.CASCADE)
   List<Tagesplan> tagesplanList;

   @OneToMany(
           mappedBy = "id.person",
           cascade = CascadeType.ALL
   )
   @OnDelete(action = OnDeleteAction.CASCADE)
   List<FavouriteGerichte> favouriteGerichteList;


   public Person() {
      SecureRandom random = new SecureRandom();
      salt = new byte[16];
      random.nextBytes(salt);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public byte[] getPassword() {
      return password;
   }

   public void setPassword(byte[] password) {
      this.password = password;
   }

   public byte[] getSalt() {
      return salt;
   }

   public void setSalt(byte[] salt) {
      this.salt = salt;
   }

   public byte[] getUniqueSessionCode() {
      return uniqueSessionCode;
   }

   public void setUniqueSessionCode(byte[] uniqueSessionCode) {
      this.uniqueSessionCode = uniqueSessionCode;
   }

   public List<FavouriteGerichte> getFavouriteGerichteList() {
      return favouriteGerichteList;
   }

   public void setFavouriteGerichteList(List<FavouriteGerichte> favouriteGerichteList) {
      this.favouriteGerichteList = favouriteGerichteList;
   }

   public List<Tagesplan> getTagesplanList() {
      return tagesplanList;
   }

   public void setTagesplanList(List<Tagesplan> tagesplanList) {
      this.tagesplanList = tagesplanList;
   }

   public static Person create(String email, String password) {
         Person newPerson = new Person();
         newPerson.setEmail(email);
         newPerson.hashPassword(password);
         return newPerson;
   }

   public void generateSessionCode(){
      this.uniqueSessionCode = this.hashRandomSalt(email);
   }

   private void hashPassword(String password){
      this.password = hash(password, this.salt);
   }

   private boolean comparePassword(String password){
      return this.password.equals(hash(password, this.salt));
   }

   private byte[] hashRandomSalt(String toHash){
      SecureRandom random = new SecureRandom();
      byte[] randomSalt = new byte[16];
      random.nextBytes(randomSalt);
      return hash(toHash, randomSalt);
   }

   private byte[] hash(String password, byte[] salt){
      KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
      SecretKeyFactory factory;
      try {
         factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
         return factory.generateSecret(spec).getEncoded();
      }catch (NoSuchAlgorithmException e){
         e.printStackTrace();
      } catch (InvalidKeySpecException e) {
         e.printStackTrace();
      }

      return null;
   }
}
