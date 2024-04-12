package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
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
   public void list(Model model){
      log.info("list..");
      log.info(boardService.getList());
      model.addAttribute("list", boardService.getList());            
      log.info("왜안돼");
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
   @GetMapping("/get")
   public String get(@RequestParam("bno")Long bno, Model model) {
	   log.info("get...." + bno);
	   model.addAttribute("board", boardService.get(bno));
	   
	   return "/board/get";
   }
   
   @GetMapping({ "/modify"})
   public String modify(@RequestParam("bno") Long bno, Model model) {
      log.info("modify.." + bno);
      model.addAttribute("board", boardService.get(bno));
      return "/board/modify";
   }
   
   @PostMapping("/modify")
   public String modify(BoardVO board, RedirectAttributes rttr) {
      log.info("modify.." + board);
      
      if(boardService.modify(board)) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/board/list";
   }
   @PostMapping("/remove")
   public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
      log.info("remove.." + bno);
      if(boardService.remove(bno)) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/board/list";
   }
}