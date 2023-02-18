package com.driver.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String userName;
        @Column(unique = true)
        private String password;
        private String firstName;
        private String lastName;

        //mapping with blog
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        List<Blog> blogList = new ArrayList<>();

        public User() {

        }

        public User(String username, String password) {
             userName = username;
            this.password = password;
            this.firstName = "test";
            this.lastName = "test";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return this.userName;
        }

        public void setUsername(String username) {
            this.userName = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<Blog> getBlogList() {
            return blogList;
        }

        public void setBlogList(List<Blog> blogList) {
            this.blogList = blogList;
        }
}