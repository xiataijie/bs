<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/getUserList',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">用户ID</th>
            <th data-options="field:'username',width:200">用户名</th>
            <th data-options="field:'password',width:100">密码</th>
            <th data-options="field:'phone',width:100">手机号码</th>
            <th data-options="field:'email',width:70">邮箱</th>
            <th data-options="field:'created',width:70">创建时间</th>
            <th data-options="field:'updated',width:100">更新时间</th>
        </tr>
    </thead>
</table>
<div id="userEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
    	var itemList = $("#userList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#userEditWindow").window({
        		onLoad :function(){
        			var data = $("#userList").datagrid("getSelections")[0];
        			$.getJSON('/restful/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	}
        	$("#userEditWindow").window({
        		onLoad :function(){
        			var data = $("#userList").datagrid("getSelections")[0];
        			$.getJSON('/restful/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
                	$.post("/user/deleteUser", {"ids":ids}, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除用户成功!',undefined,function(){
            					$("#userList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }
    ];
</script>