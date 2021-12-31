package me.workloads.person;

//import me.workloads.gerichte.Zutatenliste;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String email;
   private String password;
   private String uniqueSessionCode;

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

   public Person() {}

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

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUniqueSessionCode() {
      return uniqueSessionCode;
   }

   public void setUniqueSessionCode(String uniqueSessionCode) {
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
         newPerson.setPassword(password);
         return newPerson;
   }
}
