package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Dto.BoardDto;
import https.github.com.zzckckck3.WebtoonRec.Service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(){
        return "fragments/public/list";
    }

    @GetMapping("/postTest")
    public String write(){
        return "/fragments/public/postTest";
    }

    @PostMapping("/postTest")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
