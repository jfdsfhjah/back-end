package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody User user) {
        if (userService.insert(user) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestParam Integer id) {
        if (userService.delete(id) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody User user) {
        if (userService.update(user) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/search/{page}/{size}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable Integer page, @PathVariable Integer size, @RequestParam String name) {
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.selectByName((page - 1) * size, size, name);
        int total = userService.countByName(name);
        result.put("users", users);
        result.put("total", total);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseEntity<Map<String, Object>> list(@PathVariable Integer page, @PathVariable Integer size) {
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.selectAll((page - 1) * size, size);
        int total = userService.countAll();
        result.put("users", users);
        result.put("total", total);
        return ResponseEntity.ok(result);
    }
}
