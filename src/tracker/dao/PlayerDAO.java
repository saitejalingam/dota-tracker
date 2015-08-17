package tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tracker.model.Player;
import tracker.util.DBConnect;

public class PlayerDAO {

	public static String addPlayer(Player p){
		
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String msg = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO players_db (player_id, player_name) VALUES(?, ?)");
			ps.setInt(1, p.getPlayer_id());
			ps.setString(2, p.getPlayer_name());
			ps.executeUpdate();
			
			msg = p.getPlayer_name()+" has been Added";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}
		
		return msg;
	}
	
	public static String removePlayer(Player p){
		
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String msg = null;
		
		try {
			ps = con.prepareStatement("DELETE FROM players_db WHERE player_id =?");
			ps.setInt(1, p.getPlayer_id());
			ps.executeUpdate();
			
			msg = p.getPlayer_name()+" has been Removed";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}
		
		return msg;
	}
	
	public static List<Player> getPlayers(){
		Connection con = DBConnect.connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Player> player_list = new ArrayList<Player>();
		
		try {
			ps = con.prepareStatement("SELECT * FROM players_db");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Player player = new Player();
				player.setPlayer_id(rs.getInt("player_id"));
				player.setPlayer_name(rs.getString("player_name"));
				
				player_list.add(player);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(ps, rs, con);
		}
		
		return player_list;
	}
}

