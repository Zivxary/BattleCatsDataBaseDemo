package zxary.project.com.tw.battlecatsdatabasedemo.parse.thread;

public interface IParseThreadFactory {
    
    ParseThread create(IParseTask parseTask);
}
