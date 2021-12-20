package me.workloads.user;

//import me.workloads.gerichte.Zutatenliste;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String email;
   private String password;
   private String uniqueSessionCode;

   @OneToMany(
           mappedBy = "person",
           cascade = CascadeType.ALL
   )
   ArrayList<Geplanntes> geplanntesList = new ArrayList<>();

   /*@OneToMany(
           mappedBy = "person",
           cascade = CascadeType.ALL
   )
   ArrayList<FavoritGerichte> favoritGerichteArrayList = new ArrayList<>();*/

   public Person() {}


   public ArrayList<Geplanntes> getGeplanntesList() {
      return geplanntesList;
   }

   public void setGeplanntesList(ArrayList<Geplanntes> geplanntesList) {
      this.geplanntesList = geplanntesList;
   }

   public String getUniqueSessionCode() {
      return uniqueSessionCode;
   }

   public void setUniqueSessionCode(String uniqueSessionCode) {
      this.uniqueSessionCode = uniqueSessionCode;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
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


   public static Person create(String email, String password) {
         Person newPerson = new Person();
         newPerson.setEmail(email);
         newPerson.setPassword(password);
         return newPerson;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      Person person = (Person) o;
      return id != null && Objects.equals(id, person.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
