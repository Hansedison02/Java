package com.cvct.cvctwebsite.models;

public class QuestionModel {
String id;

String questionName = "";

public QuestionModel()
{

}

public QuestionModel(String id, String questionName)
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
