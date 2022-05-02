package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Domain.Repository.BoardRepository;
import https.github.com.zzckckck3.WebtoonRec.Dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    
}
