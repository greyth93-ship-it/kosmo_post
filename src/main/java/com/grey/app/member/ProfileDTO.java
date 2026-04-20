package com.grey.app.member;

import org.postgresql.shaded.com.ongres.scram.client.ScramClient.UsernameBuildStage;

import com.grey.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileDTO extends FileDTO{

	private String username;
}
