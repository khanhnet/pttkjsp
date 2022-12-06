package web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dichvu;
import model.Dichvudat;
import model.Hoadonxuat;
import model.Khachhang;
import model.Lichdat;
import model.Slot;
import dao.DichvuDAO;
import dao.KhachhangDAO;
import dao.LichdatDAO;
import dao.SlotDAO;

@WebServlet("/")

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachhangDAO khachhangDAO;
	private DichvuDAO dichvuDAO;
	private SlotDAO slotDAO;
	private LichdatDAO lichdatDAO;

	public void init() {
		khachhangDAO = new KhachhangDAO();
		dichvuDAO = new DichvuDAO();
		slotDAO = new SlotDAO();
		lichdatDAO = new LichdatDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/trangchu":
				trangchu(request, response);
				break;
			case "/timslot":
				timslot(request, response);
				break;
			case "/timkhachhang":
				timkhachhang(request, response);
				break;
			case "/xacnhan":
				xacnhan(request, response);
				break;
			case "/luulichdat":
				luulichdat(request, response);
				break;
			default:
				trangchu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void trangchu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("trangchu.jsp");
		dispatcher.forward(request, response);
	}

	private void timslot(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		if (request.getParameterValues("dichvu") != null) {
			String[] str = request.getParameterValues("dichvu");
			for (String s : str) {
				System.out.println(s);
			}
		}
		if (request.getParameter("time") != null) {
			String time = request.getParameter("time");
			List<Slot> listKH = slotDAO.timSlotTrong(time);
			request.setAttribute("listUser", listKH);
		}
		request.setAttribute("textget", request.getQueryString());
		List<Dichvu> listDichvu = dichvuDAO.getdichvu();
		request.setAttribute("listDichvu", listDichvu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("timslot.jsp");
		dispatcher.forward(request, response);
	}

	private void timkhachhang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		if (request.getParameter("add") != null) {
			System.out.println(request.getParameter("add"));
			String ten = request.getParameter("ten");
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String diachi = request.getParameter("diachi");
			Khachhang newKH = new Khachhang(ten, email, sdt, diachi);
			khachhangDAO.themkhachhang(newKH);
		}

		if (request.getParameter("ten") != null) {
			String name = request.getParameter("ten");
			List<Khachhang> listKH = khachhangDAO.timkhachhang(name);
			request.setAttribute("listUser", listKH);
		} else {
			List<Khachhang> listKH = khachhangDAO.getkhachhang();
			request.setAttribute("listUser", listKH);
		}
		request.setAttribute("textgetkh", request.getQueryString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("chonkhachhang.jsp");
		dispatcher.forward(request, response);
	}

	private void xacnhan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String idslot = request.getParameter("idslot");
		int idkhachhang = Integer.parseInt(request.getParameter("idkhachhang"));
		String time = request.getParameter("time");
		String[] str = request.getParameterValues("dichvu");
		Khachhang khachhang = khachhangDAO.chonKhachhang(idkhachhang);
		request.setAttribute("time", time);
		request.setAttribute("idslot", idslot);

		String listdv = "Danh sách dịch vụ: ";

		for (String s : str) {
			//System.out.println(Integer.parseInt(s));

			listdv += dichvuDAO.chonDichvu(Integer.parseInt(s)).getTen().toString() + ",";

		}
		request.setAttribute("textget", request.getQueryString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("xacnhan.jsp");
		request.setAttribute("khachhang", khachhang);
		request.setAttribute("listdv", listdv);
		dispatcher.forward(request, response);
	}

	private void luulichdat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {

		String idslot = request.getParameter("idslot");
		int idkhachhang = Integer.parseInt(request.getParameter("idkhachhang"));
		String time = request.getParameter("time");
		String[] str = request.getParameterValues("dichvu");
		Khachhang khachhang = khachhangDAO.chonKhachhang(idkhachhang);

		int timedv = 0;

		for (String s : str) {

			timedv += dichvuDAO.chonDichvu(Integer.parseInt(s)).getThoigiandukien();

		}
		System.out.println(timedv);

		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time);
		
		Timestamp timeend = new Timestamp(date1.getTime() + timedv*60000);
		
		System.out.println(timeend.toString());

		int slot = slotDAO.chonSlot(idslot).getMa();
		Lichdat newlichdat = new Lichdat(slot, idkhachhang, 1, timeend.toString(), time);
		lichdatDAO.themlichdat(newlichdat);
		
		int idlichdat=lichdatDAO.chonLichdat(slot, time).getMa();
		
		for (String s : str) {
			int gia = dichvuDAO.chonDichvu(Integer.parseInt(s)).getGia();
			Dichvudat newdvdat = new Dichvudat(idlichdat,Integer.parseInt(s),gia);
			lichdatDAO.themdichvudat(newdvdat);

		}
		
		Hoadonxuat newhdxuat = new Hoadonxuat(0,idlichdat);
		lichdatDAO.themhoadon(newhdxuat);
	
		System.out.println(timeend.toString());

		response.sendRedirect("list?thanhcong");
	}

}
