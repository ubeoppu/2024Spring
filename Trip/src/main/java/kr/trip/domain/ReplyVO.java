package kr.trip.domain;






import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
   private int replyNum;
   private int board_id;
   private String reply;
   private String member_email;
   private Time replyDate;
   private Time updateDate;
}