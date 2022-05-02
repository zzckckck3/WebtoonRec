package https.github.com.zzckckck3.WebtoonRec.Dto;

import https.github.com.zzckckck3.WebtoonRec.Domain.Entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board bulid = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return bulid;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
