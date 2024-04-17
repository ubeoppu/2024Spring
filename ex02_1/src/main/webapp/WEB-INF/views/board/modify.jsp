<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			<form role="form" action="/board/modify" method="post">
			
			<div class="form-group">
			<label>Bno</label>
			<input class="form-control" name ="bno" value="${board.bno }" >
			</div>
			
			<div class="form-group">
			<label>Title</label>
			<input class="form-control" name ="title" value="${board.title }" >
			</div>
			
			<div class="form-group">
			<label>TextArea</label>
			<textarea rows="3" class="form-control" name ="content" >${board.content }</textarea>
			</div>
			<div class="form-group">
			<label>Writer</label>
			<input class="form-control" name ="writer" value="${board.writer }">
			</div>
			<button type="submit" data-oper='modify'  class="btn btn-default">Modify Button</button>
			<button type="submit" data-oper='remove' class="btn btn-danger">Remove Button</button>
			<button type="submit" data-oper='list' class="btn btn-info">List Button</button>
			</form>
			
					<%-- 	<c:forEach var="board" items="${list}">
							<tr class="odd gradeX">
								<td>${board.bno }</td>
								<td>${board.title }</td>
								<td>${board.writer }</td>
								<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody> --%>
				<!-- </table> -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script>
$(document).ready(function(){
	
	let formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault(); 
		
		let operation = $(this).data("oper");
		
		if(operation === 'remove'){
			formObj.attr("action", "/board/remove");
		}else if(operation === 'list'){
				self.location = "/board/list";
				return;
			}
			formObj.submit();
		
	})
})
</script>
<%@include file="../includes/footer.jsp"%>
