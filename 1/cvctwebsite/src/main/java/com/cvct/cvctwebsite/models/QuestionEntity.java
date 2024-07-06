package com.cvct.cvctwebsite.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="questions")
public class QuestionEntity {

    
@Id
String id;


@Indexed(unique=true)
String questionName = "";

public QuestionEntity()
{

}

public QuestionEntity(String id, String questionName)
{
    super();
    this.id = id;
    this.questionName = questionName;
}

@Override
public String toString()
{
    return "QuestionModel [id=" + id + ", questionName=" + questionName + "]";
}

public String getId()
{
    return id;
}

public void setId(String id)
{
    this.id = id;
}

public String getQuestionName()
{
    return questionName;
}

public void setQuestionName(String questionName)
{
    this.questionName = questionName;
} 
}
