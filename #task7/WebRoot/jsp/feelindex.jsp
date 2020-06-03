<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>说说</title>
</head>
<body>
<span id="inforback"></span>
	<div id="qq">
		<form method="post" action="<%=path%>/user/publishFeel">
			<p>有什么新鲜事想告诉大家?</p>
			<div class="message" contentEditable='true'></div>
			<textarea hidden class="feelcontent" name="feelcontent"
				required="required"></textarea>
			<div class="But">
				<img src="jsp/images/bba_thumb.gif" class='bq' /> <span>发表 <input
					type="submit" class="submit">
				</span>
				<!--face begin-->
				<div class="face">
					<ul>
						<li><img src="jsp/images/zz2_thumb.gif" title="[织]"></li>
						<li><img src="jsp/images/horse2_thumb.gif" title="神马]"></li>
						<li><img src="jsp/images/fuyun_thumb.gif" title="[浮云]"></li>
						<li><img src="jsp/images/geili_thumb.gif" title="[给力]"></li>
						<li><img src="jsp/images/wg_thumb.gif" title="[围观]"></li>
						<li><img src="jsp/images/vw_thumb.gif" title="[威武]"></li>
						<li><img src="jsp/images/panda_thumb.gif" title="[熊猫]"></li>
						<li><img src="jsp/images/rabbit_thumb.gif" title="兔子]"></li>
						<li><img src="jsp/images/otm_thumb.gif" title="[奥特曼]"></li>
						<li><img src="jsp/images/j_thumb.gif" title="[囧]"></li>
						<li><img src="jsp/images/hufen_thumb.gif" title="[互粉]"></li>
						<li><img src="jsp/images/liwu_thumb.gif" title="[礼物]"></li>
						<li><img src="jsp/images/smilea_thumb.gif" title="呵呵]"></li>
						<li><img src="jsp/images/tootha_thumb.gif" title="嘻嘻]"></li>
						<li><img src="jsp/images/laugh.gif" title="[哈哈]"></li>
						<li><img src="jsp/images/tza_thumb.gif" title="[可爱]"></li>
						<li><img src="jsp/images/kl_thumb.gif" title="[可怜]"></li>
						<li><img src="jsp/images/kbsa_thumb.gif" title="[挖鼻屎]"></li>
						<li><img src="jsp/images/cj_thumb.gif" title="[吃惊]"></li>
						<li><img src="jsp/images/shamea_thumb.gif" title="[害羞]"></li>
						<li><img src="jsp/images/zy_thumb.gif" title="[挤眼]"></li>
						<li><img src="jsp/images/bz_thumb.gif" title="[闭嘴]"></li>
						<li><img src="jsp/images/bs2_thumb.gif" title="[鄙视]"></li>
						<li><img src="jsp/images/lovea_thumb.gif" title="[爱你]"></li>
						<li><img src="jsp/images/sada_thumb.gif" title="[泪]"></li>
						<li><img src="jsp/images/heia_thumb.gif" title="[偷笑]"></li>
						<li><img src="jsp/images/qq_thumb.gif" title="[亲亲]"></li>
						<li><img src="jsp/images/sb_thumb.gif" title="[生病]"></li>
						<li><img src="jsp/images/mb_thumb.gif" title="[太开心]"></li>
						<li><img src="jsp/images/ldln_thumb.gif" title="[懒得理你]"></li>
						<li><img src="jsp/images/yhh_thumb.gif" title="[右哼哼]"></li>
						<li><img src="jsp/images/zhh_thumb.gif" title="[左哼哼]"></li>
						<li><img src="jsp/images/x_thumb.gif" title="[嘘]"></li>
						<li><img src="jsp/images/cry.gif" title="[衰]"></li>
						<li><img src="jsp/images/wq_thumb.gif" title="[委屈]"></li>
						<li><img src="jsp/images/t_thumb.gif" title="[吐]"></li>
						<li><img src="jsp/images/k_thumb.gif" title="[打哈气]"></li>
						<li><img src="jsp/images/bba_thumb.gif" title="[抱抱]"></li>
						<li><img src="jsp/images/angrya_thumb.gif" title="[怒]"></li>
						<li><img src="jsp/images/yw_thumb.gif" title="[疑问]"></li>
						<li><img src="jsp/images/cza_thumb.gif" title="[馋嘴]"></li>
						<li><img src="jsp/images/88_thumb.gif" title="[拜拜]"></li>
						<li><img src="jsp/images/sk_thumb.gif" title="[思考]"></li>
						<li><img src="jsp/images/sweata_thumb.gif" title="[汗]"></li>
						<li><img src="jsp/images/sleepya_thumb.gif" title="[困]"></li>
						<li><img src="jsp/images/sleepa_thumb.gif" title="[睡觉]"></li>
						<li><img src="jsp/images/money_thumb.gif" title="[钱]"></li>
						<li><img src="jsp/images/sw_thumb.gif" title="[失望]"></li>
						<li><img src="jsp/images/cool_thumb.gif" title="[酷]"></li>
						<li><img src="jsp/images/hsa_thumb.gif" title="[花心]"></li>
						<li><img src="jsp/images/hatea_thumb.gif" title="[哼]"></li>
						<li><img src="jsp/images/gza_thumb.gif" title="[鼓掌]"></li>
						<li><img src="jsp/images/dizzya_thumb.gif" title="[晕]"></li>
						<li><img src="jsp/images/bs_thumb.gif" title="[悲伤]"></li>
						<li><img src="jsp/images/crazya_thumb.gif" title="[抓狂]"></li>
						<li><img src="jsp/images/h_thumb.gif" title="[黑线]"></li>
						<li><img src="jsp/images/yx_thumb.gif" title="[阴险]"></li>
						<li><img src="jsp/images/nm_thumb.gif" title="[怒骂]"></li>
						<li><img src="jsp/images/hearta_thumb.gif" title="[心]"></li>
						<li><img src="jsp/images/unheart.gif" title="[伤心]"></li>
						<li><img src="jsp/images/pig.gif" title="[猪头]"></li>
						<li><img src="jsp/images/ok_thumb.gif" title="[ok]"></li>
						<li><img src="jsp/images/ye_thumb.gif" title="[耶]"></li>
						<li><img src="jsp/images/good_thumb.gif" title="[good]"></li>
						<li><img src="jsp/images/no_thumb.gif" title="[不要]"></li>
						<li><img src="jsp/images/z2_thumb.gif" title="[赞]"></li>
						<li><img src="jsp/images/come_thumb.gif" title="[来]"></li>
						<li><img src="jsp/images/sad_thumb.gif" title="[弱]"></li>
						<li><img src="jsp/images/lazu_thumb.gif" title="[蜡烛]"></li>
						<li><img src="jsp/images/clock_thumb.gif" title="[钟]"></li>
						<li><img src="jsp/images/cake.gif" title="[蛋糕]"></li>
						<li><img src="jsp/images/m_thumb.gif" title="[话筒]"></li>
						<li><img src="jsp/images/weijin_thumb.gif" title="[围脖]"></li>
						<li><img src="jsp/images/lxhzhuanfa_thumb.gif" title="[转发]"></li>
						<li><img src="jsp/images/lxhluguo_thumb.gif" title="[路过这儿]"></li>
						<li><img src="jsp/images/bofubianlian_thumb.gif"
							title="[bofu变脸]"></li>
						<li><img src="jsp/images/gbzkun_thumb.gif" title="[gbz困]"></li>
						<li><img src="jsp/images/boboshengmenqi_thumb.gif"
							title="[生闷气]"></li>
						<li><img src="jsp/images/chn_buyaoya_thumb.gif" title="[不要啊]"></li>
						<li><img src="jsp/images/daxiongleibenxiong_thumb.gif"
							title="[dx泪奔]"></li>
						<li><img src="jsp/images/cat_yunqizhong_thumb.gif"
							title="[运气中]"></li>
						<li><img src="jsp/images/youqian_thumb.gif" title="[有钱]"></li>
						<li><img src="jsp/images/cf_thumb.gif" title="[冲锋]"></li>
						<li><img src="jsp/images/camera_thumb.gif" title="[照相机]"></li>
					</ul>
				</div>
				<!--face end-->
			</div>
		</form>
	</div>
	<!--qq end-->

 	<div class="msgCon">
		<c:set var="feels" value="${allfeels.getList()}" />
		<c:set var="pager" value="${allfeels }" />
		<c:if test="${!empty feels }">
			<c:forEach items="${feels}" var="feel" varStatus="status">
				<div class='msgBox'>
					<dl>
						<dt>
							<img src="headpic/${feel.user.headpic }"
								alt="${feel.user.username }" height="50" width="50">
						</dt>
						<dd>
							${feel.user.username } <span style="font-size: 7px;">${feel.feel.timestring }</span>
							<c:if test="${host.userid==feel.user.userid }">
								<a
									href="<%=path %>/user/deleteFeel?feelid=${feel.feel.feelid}&userid=${feel.user.userid }&currentPage=${pager.pageNum }">
									<span style="font-size: 7px;" onclick="return operaconfirm('删除');">删除</span>
								</a>
							</c:if>
						</dd>
					</dl>
					<div class='msgTxt'>
						${feel.feel.feelcontent }<br>
						<c:if test="${!empty feel.feel.pic}">
							<img src="img/${feel.feel.pic }" height="50" width="70">
						</c:if>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div> 
	<div class="comm_content">
		<div class="c_list clf">
			<div id="pl_page">
				<div class="pagelistbox">
					<p>
						<span> <c:if test="${pager.isFirstPage==false}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=1">首页</a>
							</c:if> <c:if test="${pager.hasPreviousPage==true}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pageNum-1}">上一页</a>
							</c:if> <c:if test="${pager.hasNextPage==true}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pageNum+1}">下一页</a>
							</c:if> <c:if test="${pager.isLastPage ==false}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pages}">尾页</a>
							</c:if> 当前第 ${pager.pageNum}页, 总共${pager.pages} 页
						</span>
					</p>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
	
	$(function(){
		
		//点击小图片，显示表情
		$(".bq").click(function(e) {
			$(".face").slideDown();//慢慢向下展开
			e.stopPropagation(); //阻止冒泡事件
		});

		//在桌面任意地方点击，他是关闭
		$(document).click(function() {
			$(".face").slideUp();//慢慢向上收
		});

		//点击小图标时，添加功能
		$(".face ul li").click(function() {
			var simg = $(this).find("img").clone();
			$(".message").append(simg);
		});
		//点击提交按钮把div中的值复制给textarea控件
		$(".submit").click(function() {
			var txt = $(".message").html();
			if (txt == "") {
				$('.message').focus();//自动获取焦点
				return;
			}
			$(".feelcontent").html(txt);
		});
	});
	function operaconfirm(op) {
		question = confirm("你确定要"+op+"么？"); 
		 	if (question != "0") {
			return true;
		}
		return false;  
	}
</script>
</body>
</html>
