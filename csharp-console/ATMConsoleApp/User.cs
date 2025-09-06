using System;

public class User
{
    public string Name { get; set; }
    public string CourseAndSection { get; set; }
    public string Subject { get; set; }
    
    public User(string name, string courseAndSection, string subject)
    {
        Name = name;
        CourseAndSection = courseAndSection;
        Subject = subject;
    }
}