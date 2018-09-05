<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<style type="text/css">
			.top {
			   /*  width: 670px; */
			    height: 80px;
			    background-color: #CCCCCC;
			}
		    td { font-size:12; text-align:center; }
		    a:link { text-decoration:none; }
		    a:visited { text-decoration:none; }
		    a:hover { text-decoration:none; }
		    a:active { text-decoration:none; }
		</style>
		
		<script language='javascript' type='text/javascript'> //<![CDATA[
		    var muCnt = 5;
		    function fncShow( pos ) {
		        var i = 0;
		        for (i; i<muCnt; i++) {
		            var obj = document.getElementById("menu" + i);
		            var obj2 = document.getElementById("m" + i);
		            if (i == pos) {
		                obj.style.display = '';
		                obj2.style.color="#CC99CC";
		            } else {
		                obj.style.display = 'none';
		                obj2.style.color = "#000000";
		            }
		        }
		    }
		    function fncHide (pos) {
		        var obj = document.getElementById("menu" + pos);
		        obj.style.disply = 'none';
		    } //]]
		</script>
	
	<div class="top">
		<table cellpadding='0' cellspacing='1' border='0' width='800' height='60' align="center">
		    <tr height='30'>
		        <td width='100' onmouseover='fncShow(0);' id='m0'><b> 리조트소개 </b></td>
		        <td width='100' onmouseover='fncShow(1);' id='m1'><b> 찾아오기 </b></td>
		        <td width='100' onmouseover='fncShow(2);' id='m2'><b> 주변여행지 </b></td>
		        <td width='100' onmouseover='fncShow(3);' id='m3'><b> 예약하기 </b></td>
		        <td width='100' onmouseover='fncShow(4);' id='m4'><b> 리조트소식 </b></td>
		        <td width='100'></td>
		
		    </tr>
		    <tr height='30'>
		        <td colspan='6'>
		            <table id='menu0' style='display:none;' cellpadding='0' cellspacing='0' border='0' width='600' height='30'>
		                <tr>
		                    <td width='0'></td>
		                    <td width='600' style='text-align:left;'>
		                        <a href="main" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 그루 리조트 </span>
		                        </a>
		                        <a href="vip" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | VIP룸 </span>
		                        </a>
		                        <a href="general" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 일반룸 </span>
		                        </a>
		                        <a href="resonable" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 합리적인룸 | </span>
		                        </a>
		                    </td>
		                </tr>
		            </table>
		            <table id='menu1' style='display:none;' cellpadding='0' cellspacing='0' width='600' height='30'>
		                <tr>
		                    <td width='100'></td>
		                    <td width='500' style='text-align:left;'>
		                        <a href="location" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 찾아오는길 </span>
		                        </a>
		                        <a href="public" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 대중교통이용 </span>
		                        </a>
		                        <a href="car" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 자가용이용 | </span>
		                        </a>
		                    </td>
		                </tr>
		            </table>
		
		            <table id='menu2' style='display:none;' cellpadding='0' cellspacing='0' border='0' width='600' height='30'>
		                <tr>
		                    <td width='200'></td>
		                    <td width='400' style='text-align:left;'>
		                        <a href="mountain" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 높아산 </span>
		                        </a>
		                        <a href="beach" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 푸른해수욕장 </span>
		                        </a>
		                        <a href="spa" target=main>
		                            <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 따끈온천 | </span>
		                        </a>
		                    </td>
		                </tr>
		            </table>
		            
		            <table id='menu3' style='display:none;' cellpadding='0' cellspacing='0' border='0' width='600' height='30'>
		                    <tr>
		                        <td width='300'></td>
		                        <td width='250' style='text-align:left;'>
		                            <a href="list" target=main>
		                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 예약상황 </span>
		                            </a>
		                            <a href="insertForm" target=main>
		                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 예약하기 </span>
		                            </a>
		                            <a href="adm_allview.jsp" target=main>
		                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 관리자페이지 </span>
		                            </a>
		                            <a href="adm_logout.jsp" target=main>
		                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 관리자로그아웃 | </span>
		                            </a>
		                        </td>
		                    </tr>
		                </table>
		
		                <table id='menu4' style='display:none;' cellpadding='0' cellspacing='0' border='0' width='800' height='30'>
		                        <tr>
		                            <td width='350'></td>
		                            <td width='250' style='text-align:left;'>
		                                <a href="e_01.jsp" target=main>
		                                    <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 리조트소식 </span>
		                                </a>
		                                <a href="e_02.jsp" target=main>
		                                    <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'> | 이용후기 | </span>
		                                </a>
		                            </td>
		                        </tr>
		                </table>
		        </td>
		    </tr>
		</table>
	</div>