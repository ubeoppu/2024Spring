package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
   
   private final BoardService boardService;
   
   @GetMapping("/list")
   public void list(Criteria cri,Model model){
      log.info("list.." + cri);
      log.info( boardService.getList(cri));
      model.addAttribute("list", boardService.getList(cri));
      model.addAttribute("pageMaker", new PageDTO(cri, 123));
      log.info(new PageDTO(cri, 123));
      log.info(boardService.getTotal(cri));
   }
   @GetMapping("register")
   public void register() {
      
   }
   @PostMapping("/register")
   public String register(BoardVO board, RedirectAttributes rttr) {
      log.info("register..");
      boardService.register(board);
      rttr.addFlashAttribute("result", board.getBno());
      return "redirect:/board/list";
   }
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri")Criteria cri) {
		log.info("get + modify......" + bno);
		
		log.info("cri!!" + cri);
		model.addAttribute("board", boardService.get(bno)); // views/board/get.jsp
		model.addAttribute("cri", cri);
		
	}   
   @PostMapping("/modify")
   public String modify(BoardVO board,@ModelAttribute("cri")Criteria cri ,RedirectAttributes rttr) {
      log.info("modify.." + board);
      
      if(boardService.modify(board)) {
         rttr.addFlashAttribute("result", "modify");
         log.info(cri.getPageNum());
         rttr.addAttribute("pageNum", cri.getPageNum());
         rttr.addAttribute("amount", cri.getAmount());
      }
      return "redirect:/board/list";
   }
   @PostMapping("/remove")
   public String remove(@RequestParam("bno") Long bno,@ModelAttribute("cri")Criteria cri ,RedirectAttributes rttr) {
      log.info("remove.." + bno);
      if(boardService.remove(bno)) {
         rttr.addFlashAttribute("result", "delete");
         rttr.addAttribute("pageNum", cri.getPageNum());
         rttr.addAttribute("amount", cri.getAmount());
      }
      return "redirect:/board/list";
   }
   
   
}