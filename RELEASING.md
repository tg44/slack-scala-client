- Edit `project/Build` to name the new version
- Edit README.md to name the new version
- Edit CHANGELOG.md
- git commit, git push
- git tag
- make sure `~/.gnupg/gpg.conf` lists the proper key as the default one (check with `gpg --list-key`)
- `export GPG_TTY=$(tty)` (Mac only)
- `sbt +publishSigned`
- In Sonatype Close the staging repository, and Release it.