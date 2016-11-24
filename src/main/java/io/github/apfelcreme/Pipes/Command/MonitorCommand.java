package io.github.apfelcreme.Pipes.Command;

import io.github.apfelcreme.Pipes.Manager.ItemMoveScheduler;
import io.github.apfelcreme.Pipes.Manager.PipeManager;
import io.github.apfelcreme.Pipes.Pipes;
import io.github.apfelcreme.Pipes.PipesConfig;
import org.bukkit.command.CommandSender;

/**
 * Copyright (C) 2016 Lord36 aka Apfelcreme
 * <p>
 * This program is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses/>.
 *
 * @author Lord36 aka Apfelcreme
 */
public class MonitorCommand implements SubCommand {

    /**
     * executes the command
     *
     * @param commandSender the sender
     * @param strings       the command args
     */
    @Override
    public void execute(final CommandSender commandSender, String[] strings) {
        if (commandSender.hasPermission("Pipes.monitor")) {
            Pipes.sendMessage(commandSender, PipesConfig.getText("info.monitor.pipeCache")
                    .replace("{0}", String.valueOf(PipeManager.getInstance().getPipeCache().size())));
            if (ItemMoveScheduler.getInstance().isActive()) {
                Pipes.sendMessage(commandSender, PipesConfig.getText("info.monitor.schedulerActive"));
            } else {
                Pipes.sendMessage(commandSender, PipesConfig.getText("info.monitor.schedulerNotActive"));
            }
            Pipes.sendMessage(commandSender, PipesConfig.getText("info.monitor.version")
                    .replace("{0}", Pipes.getInstance().getDescription().getVersion()));
        } else {
            Pipes.sendMessage(commandSender, PipesConfig.getText("error.noPermission"));
        }
    }
}