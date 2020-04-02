package kr.co.apps.vo;

public class MyDocumentVo {
    
    Integer key = null;
    String title = null;
    String taskId = null;

    public int getKey()
    {
        return this.key;
    }
    
    public void setKey(int key)
    {
        this.key = key;
    }

    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getTaskId()
    {
        return this.taskId;
    }
    
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }
    
}
