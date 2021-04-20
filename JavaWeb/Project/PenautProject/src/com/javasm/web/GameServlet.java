package com.javasm.web;

import com.javasm.entity.Game;
import com.javasm.service.GameService;
import com.javasm.service.impl.GameServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.RequestDataConvert;
import com.javasm.vo.GameTypeEntity;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-16:51
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/gameServlet.do")
public class GameServlet extends BaseServlet<Game> {
    private GameService gameService = new GameServiceImpl();
    private Game game = new Game();

    /**
     * 文件上传
     */
    public void fileGame(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String fileName = "";
        String realPath = request.getRealPath("/");
        System.out.println(realPath);
        File fileGameIcon = new File(realPath + "upload//gameIcon");
        File fileGameDetails = new File(realPath + "upload//gameDetails");
        File fileIosUrl = new File(realPath + "upload//iosUrl");
        File fileAndroidUrl = new File(realPath + "upload//androidUrl");
        if (!fileGameIcon.exists()) {
            fileGameIcon.mkdirs();
        }
        if (!fileGameDetails.exists()) {
            fileGameDetails.mkdirs();
        }
        if (!fileIosUrl.exists()) {
            fileIosUrl.mkdirs();
        }
        if (!fileAndroidUrl.exists()) {
            fileAndroidUrl.mkdirs();
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("表单元素的name：" + fileItem.getFieldName() + "=" + fileItem.getString());
                    } else {
                        String filePath = realPath + "//upload";
                        fileName = new Date().getTime() + fileItem.getName();
//                        File newFile = new File(filePath + "//" + fileName);
//                        fileItem.write(newFile);
                        System.out.println(fileItem.getFieldName());
                        if (fileItem.getFieldName().equals("gameIcon")) {
                            File newFile = new File(filePath + "//" + "//gameIcon//" + fileName);
                            fileItem.write(newFile);
                            game.setGameIcon("upload/gameIcon/" + fileName);
//                            map.put(fileName,)
                        }
                        if (fileItem.getFieldName().equals("gameDetails")) {
                            File newFile = new File(filePath + "//" + "//gameDetails//" + fileName);

                            fileItem.write(newFile);
                            game.setGameDetails("upload/gameDetails/" + fileName);
                        }
                        if (fileItem.getFieldName().equals("iosUrl")) {
                            File newFile = new File(filePath + "//" + "//iosUrl//" + fileName);
                            fileItem.write(newFile);
                            game.setIosUrl("upload/iosUrl/" + fileName);
                        }
                        if (fileItem.getFieldName().equals("androidUrl")) {
                            File newFile = new File(filePath + "//" + "//androidUrl//" + fileName);
                            fileItem.write(newFile);
                            game.setAndroidUrl("upload/androidUrl/" + fileName);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 游戏添加
     *
     * @param request
     * @param response
     */
    public void addGame(HttpServletRequest request, HttpServletResponse response) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    System.out.println(fileItem.getFieldName());
                    switch (fileItem.getFieldName()) {
                        case "gameId":
                            game.setGameId(Integer.valueOf(fileItem.getString()));
                            break;
                        case "gameName":
                            game.setGameName(fileItem.getString());
                            break;
                        case "gameTitle":
                            game.setGameTitle(fileItem.getString());
                            break;
                        case "gameSize":
                            game.setGameSize(Float.valueOf(fileItem.getString()));
                            break;
                        case "gameDownloads":
                            game.setGameDownloads(Integer.valueOf(fileItem.getString()));
                            break;
                        case "gameRecommendType":
                            game.setGameRecommendType(Integer.valueOf(fileItem.getString()));
                            break;
                        case "state":
                            game.setState(Integer.valueOf(fileItem.getString()));
                            break;
                        case "gameClassify":
                            game.setGameClassify(fileItem.getString());
                            break;
                        case "gamePlatformType":
                            game.setGamePlatformType(Integer.valueOf(fileItem.getString()));
                            break;
                        case "gameOver":
                            game.setGameOver(fileItem.getString());
                            break;
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        boolean flag = gameService.addGame(game);
        if (flag) {

            try {
                response.sendRedirect("gameServlet.do?type=queryGame");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('登录失败!');window.location.href='game.jsp'</script>");
        }
    }

    /**
     * 删除游戏
     *
     * @param request
     * @param response
     */
    public void deleteGame(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String gameIdStr = request.getParameter("gameId");
        Integer gameId = ConvertUtils.StringConvertInteger(gameIdStr);
        GameService gameService = new GameServiceImpl();
        boolean b = gameService.deleteGame(gameId);
        if (b) {
            request.getRequestDispatcher("games.jsp").forward(request, response);
        }
    }

    /**
     * 初始化游戏
     *
     * @param request
     * @param response
     */
    public void updateGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String gameId = request.getParameter("gameId");
        Game game = gameService.ShowGameById(ConvertUtils.StringConvertInteger(gameId));
        request.setAttribute("game", game);
        request.getRequestDispatcher("updateGame.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, InstantiationException, IllegalAccessException {
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        List<FileItem> items = upload.parseRequest(request);
//        Object game = request.getAttribute("game");
//        System.out.println(game.toString());
//        for (FileItem item : items) {
//            System.out.println(items);
//        }
        Game game = RequestDataConvert.convertToEntityByField(Game.class, request);
        gameService.updateGame(game);

    }

    /**
     * 显示所有游戏
     *
     * @param request
     * @param response
     */
    public void queryGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GameTypeEntity> gameTypeEntity = gameService.show();
        request.setAttribute("game", gameTypeEntity);
        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
}
