package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.MePageAddFriend;
import web.member.bean.TopupProducts;
import web.member.dao.PremiumTopupProductsDao;

public class PremiumTopupProductsDaoImpl implements PremiumTopupProductsDao {

	private DataSource dataSource;

	public PremiumTopupProductsDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TopupProducts> topupProducts( ) {
//		String sql = "select po.uid,po.order_status ,p.product_name ,p.product_content, p.product_pic,pod.product_quantity,pod.product_current_price,p.product_price from point_order po left join point_order_details pod on po.id = pod.point_id left join point p on pod.point_id = p.id where po.uid = ? ";
		String sql = "select product_name, product_pic, product_price,PRODUCT_CONTENT from point ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setString(1, topupProducts.getUid());
			ResultSet rs = pstmt.executeQuery();
			List<TopupProducts> tplist = new ArrayList<>();
			while (rs.next()) {
				TopupProducts tp= new TopupProducts();
//				tp.setOrder_status(rs.getString("order_status"));
//				tp.setProduct_quantity(rs.getString("product_quantity"));
//				tp.setPRODUCT_current_PRICE(rs.getString("product_current_price"));
				tp.setPRODUCT_CONTENT(rs.getString("PRODUCT_CONTENT"));
				tp.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				tp.setPRODUCT_PIC(rs.getBytes("PRODUCT_PIC"));
				tp.setPRODUCT_PRICE(rs.getString("PRODUCT_PRICE"));
				tplist.add(tp);
			}

			return tplist;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
