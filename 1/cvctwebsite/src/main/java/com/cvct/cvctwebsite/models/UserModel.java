package com.cvct.cvctwebsite.models;

public class UserModel {

    String id;

    String username = "";

    String password = "";

    String fname = "";

    String lname = "";

    String email = "";

    String role = "";

    String institute = "";

public UserModel()
{

}

public UserModel(String id, String username, String password, String fname, String lname, String email, String role, String institute)
{
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.role = role;
    this.institute = institute;

}

@Override
public String toString()
{
    return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", role=" + role + ", institute=" + institute + "]";
}

public String getId()
{
    return id;
}

public void setId(String id)
{
    this.id = id;
}

public String getUsername()
{
    return username;
}

public void setUsername(String username)
{
    this.username = username;
}

public String getPassword()
{
    return password;
}

public void setPassword(String password)
{
    this.password = password;
}

public String getFname()
{
    return fname;
}

public void setFname(String fname)
{
    this.fname = fname;
}

public String getLname()
{
    return lname;
}

public void setLname(String lname)
{
    this.lname = lname;
}

public String getEmail()
{
    return email;
}

public void setEmail(String email)
{
    this.email = email;
}

public String getRole()
{
    return role;
}

public void setRole(String role)
{
    this.role = role;
}

public String getInstitute()
{
    return institute;
}

public void setInstitute(String institute)
{
    this.institute = institute;
}
}
