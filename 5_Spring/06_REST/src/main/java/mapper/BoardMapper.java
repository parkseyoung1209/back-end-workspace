package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
	void addBoard(Board board);
	List<Board> readBoard(Paging paging);
	Board readChooseBoard(int num);
	void update(Board vo);
	void delete(int no);
}
