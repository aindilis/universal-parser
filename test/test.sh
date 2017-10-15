for mandatory_binary in "${mandatory_binaries[@]}"; do if ! type "$mandatory_binary" > /dev/null; then echo "Please install $mandatory_binary" exit; fi; done
